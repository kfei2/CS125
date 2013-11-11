//UIUC CS125 FALL 2013 MP. File: Person.java, CS125 Project: Challenge6-RecursionSee, Version: 2013-11-05T17:51:57-0600.490903127
/**
 * @author yangli15
 *
 */
public class Person
{
	private final String name;
	private final int age;
	private final char gender;
	private final Person child1; //left child
	private final Person child2; //right child
	
	public Person(String name, int age, char gender, Person c1, Person c2)
	{
	    this.name=name;
	    this.age=age;
	    this.gender=gender;
	    this.child1 = c1;
	    this.child2 = c2;
	}
	
	public String toString()
	{
	    return name+"*"+age+"*"+gender;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public int getAge() 
	{
		return age;
	}
	
	public char getGender() 
	{
		return gender;
	}
	
	public boolean equals(Person p)
	{
		return (this.name.equals(p.name)) &&
				(this.age==p.age) &&
				(this.gender==p.gender);
	}
	
	
	public void print() 
	{
	   System.out.println(this);
	   if(child1 != null)
	       child1.print();
	   if(child2 != null)
	       child2.print();
	   
	}
	
	public int count() // total person count including this object
	{
		int count = 1;
		if(child1 != null)
			count += child1.count();
		if(child2 != null)
			count += child2.count();
		return count;
	}
	
	public int countGrandChildren() // but not greatGrandChildren
	{
		return countChildren(2);
	}
	
	public int countChildren(int generations)
	{
		int count = 0;
		if(generations == 1)
		{
			if(child1 != null)
				count++;
			if(child2 != null)
				count++;
			return count;
		}
		if(child1 == null && child2 == null)
			return 0;
		else if(child1 == null)
			return child2.countChildren(generations-1);
		else if(child2 == null)
			return child1.countChildren(generations-1);
		return child1.countChildren(generations-1) + child2.countChildren(generations-1);
	}
	
	public int countMaxGenerations()
	{
		int oldest = 0;
		if(child1 != null)
			oldest = child1.countMaxGenerations();
		if(child2 != null)
			oldest = Math.max(oldest, child2.countMaxGenerations());
		return oldest + 1;
	}
	
	public int countGender(char gen)
	{
		int count;
		if(this.gender == gen)
			count = 1;
		else
			count = 0;
		if(child1 != null)
			count = child1.countGender(gen) + count;
		if(child2 != null)
			count = child2.countGender(gen) + count;
		return count;
	}
	
	
	public Person search(String name, int maxGeneration)
	{
		Person p1 = null;
		Person p2 = null;
		
		if(maxGeneration == 0)
			if(this.name.equals(name))
				return this;
			else
				return null;
		
		if(this.name.equals(name))
			return this;
		if(child1 != null)
			p1 = child1.search(name, maxGeneration - 1);
		if(p1 != null)
			return p1;
		if(child2 != null)
			p2 = child2.search(name, maxGeneration - 1);
		if(p2 != null)
			return p2;
		return null;
	}

} // end of class
