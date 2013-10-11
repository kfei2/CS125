//UIUC CS125 FALL 2013 MP. File: PixelEffects.java, CS125 Project: Challenge4-Photoscoop, Version: 2013-10-05T06:40:40-0500.341111555

/* A class to implement the various pixel effects.
 *
 * Todo: Put your netid (i.e. username) in the line below
 * 
 * @author yangli15
 */
public class PixelEffects {

	/** Copies the source image to a new 2D integer image */
	public static int[][] copy(int[][] source) {
		// Create a NEW 2D integer array and copy the colors across
		int[][] newArray = new int[source.length][source[0].length];
		
		for(int i = 0; i < source.length; i++)
			for(int j = 0; j < source[0].length;j++)
				newArray[i][j] = source[i][j];
		// See redeye code below
		return newArray;
	}

	/**
	 * Resize the array image to the new width and height You are going to need
	 * to figure out how to map between a pixel in the destination image to a
	 * pixel in the source image
	 * 
	 * @param source
	 * @param newWidth
	 * @param newHeight
	 * @return
	 */
	public static int[][] resize(int[][] source, int newWidth, int newHeight) {
		int[][] tgt = new int[newWidth][newHeight];
		int srcW = source.length;
		int srcH = source[0].length;
		int tgtW = newWidth;
		int tgtH = newHeight;
		
		for(int tgtX = 0; tgtX < tgtW; tgtX++)
		{
			for(int tgtY = 0; tgtY < tgtH; tgtY++)
			{
				int srcY = (int)(((double)tgtY/(double)tgtH)*srcH);
				int srcX = (int)(((double)tgtX/(double)tgtW)*srcW);
				tgt[tgtX][tgtY] = source[srcX][srcY];
			}
		}
		return tgt;
	}

	/**
	 * Half the size of the image. This method should be just one line! Just
	 * delegate the work to resize()!
	 */
	public static int[][] half(int[][] source) {
		return resize(source, source.length / 2, source[0].length / 2);
	}

	/**
	 * Create a new image array that is the same dimesions of the reference
	 * array. The array may be larger or smaller than the source. Hint - this
	 * methods should be just one line - delegate the work to resize()!
	 * 
	 * @param source
	 *            the source image
	 * @param reference
	 * @return the resized image
	 */
	public static int[][] resize(int[][] source, int[][] reference) {
		return resize(source, reference.length, reference[0].length);
	}

	/** Flip the image vertically */
	public static int[][] flip(int[][] source) {
		int[][] newArray = new int[source.length][source[0].length];
		for (int i = 0; i < source.length; i++) 
		{
			for(int j = 0; j < source[0].length;j++)
				newArray[i][source[0].length-j-1] = source[i][j];
		}
		return newArray;
	}

	/** Reverse the image horizontally */
	public static int[][] mirror(int[][] source) {
		int[][] newArray = new int[source.length][source[0].length];
		for(int i = 0; i < source.length;i++)
		{
			newArray[newArray.length-i-1] = source[i];
		}
		return newArray;
	}

	/** Rotate the image */
	public static int[][] rotateLeft(int[][] source) {
		int srcW = source.length;
		int srcH = source[0].length;
		int tgtW = srcH;
		int tgtH = srcW;
		int[][] tgt = new int[tgtW][tgtH];
		
		for(int i = 0; i < tgtW; i++)
		{
			for(int j = 0; j < tgtH; j++)
				tgt[i][j] = source[j][i];
		}
		
		tgt = flip(tgt);
		return tgt;
	}

	//TODO
	/** Merge the red,blue,green components from two images */
	public static int[][] merge(int[][] sourceA, int[][] sourceB) {
		int[][] background = resize(sourceB, sourceA);
		int[][] merged = new int[sourceA.length][sourceA[0].length];
		for(int i = 0; i < sourceA.length;i++)
			for(int j = 0; j < sourceA[0].length;j++)
			{
				int red = (RGBUtilities.toRed(sourceA[i][j]) + RGBUtilities.toRed(background[i][j])) / 2;
				int green = (RGBUtilities.toGreen(sourceA[i][j]) + RGBUtilities.toGreen(background[i][j])) / 2;
				int blue = (RGBUtilities.toBlue(sourceA[i][j]) + RGBUtilities.toBlue(background[i][j])) / 2;
				merged[i][j] = RGBUtilities.toRGB(red, green, blue);
			}
		// The output should be the same size as the input. Scale (x,y) values
		// when reading the background
		// (e.g. so the far right pixel of the source is merged with the
		// far-right pixel ofthe background).
		return merged;
	}

	// TODO
	/**
	 * Replace the green areas of the foreground image with parts of the back
	 * image
	 */
	public static int[][] chromaKey(int[][] foreImage, int[][] backImage) {
		int[][] foreground = resize(foreImage, backImage);
		// If the image has a different size than the background use the
		// resize() method
		// create an image the same as the background size.
		for(int i = 0; i < foreground.length; i++)
			for(int j = 0; j < foreground[0].length; j++)
			{
				int red = RGBUtilities.toRed(foreground[i][j]);
				int green = RGBUtilities.toGreen(foreground[i][j]);
				int blue = RGBUtilities.toBlue(foreground[i][j]);
				if(green > (red + blue))
					foreground[i][j] = backImage[i][j];
			}
		return foreground;
	}

	/** Removes "redeye" caused by a camera flash. sourceB is not used */
	public static int[][] redeye(int[][] source, int[][] sourceB) {

		int width = source.length, height = source[0].length;
		int[][] result = new int[width][height];
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++) {
				int rgb = source[i][j];
				int red = RGBUtilities.toRed(rgb);
				int green = RGBUtilities.toGreen(rgb);
				int blue = RGBUtilities.toBlue(rgb);
				if (red > 4 * Math.max(green, blue) && red > 64)
					red = green = blue = 0;
				result[i][j] = RGBUtilities.toRGB(red, green, blue);
			}

		return result;
	}

	/* randomly selects source or sourceB for each array value and puts it in the new array */
	public static int[][] funky(int[][] source, int[][] sourceB) {
		int[][] background = resize(sourceB, source);
		int[][] newArray = new int[source.length][source[0].length];
		
		for(int i = 0; i < newArray.length; i++)
			for(int j = 0; j < newArray[0].length; j++)
			{
				int x = (int)(Math.random()*source.length);
				int y = (int)(Math.random()*source[0].length);
				double which = Math.random();
				if(which < 0.5)
					newArray[i][j] = source[x][y];
				else
					newArray[i][j] = background[x][y];
			}

		return newArray;
	}
}
