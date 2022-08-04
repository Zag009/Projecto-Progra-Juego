import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Goo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Goo extends Actor
{
    private int counter = 0;
    
    int MOVE_X = 5;
    int MOVE_Y = 5;
    int rightSideOfScreen;
    int bottomOfScreen;
    public Goo()
    {
        GreenfootImage myImage = getImage();
        int myNewHeight = (int)myImage.getHeight()/3;
        int myNewWidth = (int)myImage.getWidth()/3;
        myImage.scale(myNewWidth, myNewHeight);
        
    }
    
    public void addedToWorld(World grass)
    {
        rightSideOfScreen = grass.getWidth() - 1;
        bottomOfScreen = grass.getWidth() - 1;
    }
    
    public void act()
    {
        move(4);
        int x = getX();
        int y = getY();
        
        if(x<=0 || y<=0 || x>= rightSideOfScreen || y>= bottomOfScreen)
        {
            setRotation(Greenfoot.getRandomNumber(360));
        }
        
        counter = counter +1;
        if (counter == 300)
        {
            ((MyWorld)getWorld()).removeObject(this);
        }
    }
}
