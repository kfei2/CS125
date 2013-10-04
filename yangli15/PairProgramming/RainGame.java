//UIUC CS125 FALL 2013 MP. File: RainGame.java, CS125 Project: PairProgramming, Version: 2013-10-01T11:29:17-0500.581108460
/**
 * @author yangli15, amychen4
 */
public class RainGame 
{

	public static void main(String[] args) 
	{
		// To get points type your netids above (CORRECTLY-Please double check your partner correctly spells your netid correctly!!)
		// Your netid is the unique part of your @illinois email address
		// Do not put your name or your UIN. 
		// REMEMBER TO COMMIT this file...
	
		int x=0, y=0, dx=0, dy=0, score = -1, level = 0;
		String text = "";
		long startTime =System.currentTimeMillis();
		
		Zen.setFont("Times-64");
		while (Zen.isRunning()) 
		{

			if (text.length() == 0) 
			{
				x = Zen.getZenWidth() / 2 - 50;
				y = 0;
				dx = 0;
				dy = 2;
				text = "" + (int) (Math.random() * 999);
				long elapsed = System.currentTimeMillis() - startTime;

				startTime = System.currentTimeMillis();
				//score += 3000 / elapsed;
				score++;
				
				if(score == 10)
				{
					score = 0;
					level++;
				}
			}
			Zen.setColor(102, 102, 255);
			Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());

			Zen.setColor(0, 255, 0);
			Zen.drawText(text, x, y);
			
			Zen.drawText("Level: " + level,10,50);
			Zen.drawText("Score: " + score,10,100);
			
			x += dx*(level+1);
			y += dy*(level+1);
			
			if(y > Zen.getZenHeight()+50)
			{
				Zen.setColor(255,0,0);
				Zen.drawText("We give up. GG", 100,250);
			}
			
			// Find out what keys the user has been pressing.
			String user = Zen.getEditText();
			// Reset the keyboard input to an empty string
			// So next iteration we will only get the most recently pressed keys.
			Zen.setEditText("");
			
			for(int i=0;i < user.length();i++) 
			{
				char c = user.charAt(i);
				if(c == text.charAt(0))
					text = text.substring(1,text.length()); // all except first character
			}
			Zen.sleep(90);// sleep for 90 milliseconds

		}
	}

}
