import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mouse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mouse extends Actor
{
    public Mouse ()
    {
        GreenfootImage myImage = getImage();
        int myNewHeight = (int)myImage.getHeight()/2;
        int myNewWidth = (int)myImage.getWidth()/2;
        myImage.scale(myNewWidth, myNewHeight);
    }
    int rightSideOfScreen;
    int bottomOfScreen;
    
    public void addedToWorld(World grass)
    {
        rightSideOfScreen = grass.getWidth() - 1;
        bottomOfScreen = grass.getWidth() - 1;
    }
    
    public void act()
    {
        move(10);
        if(Greenfoot.getRandomNumber(20)==1)
        {
            setRotation(Greenfoot.getRandomNumber(360));
        }
        
        int x = getX();
        int y = getY();
        
        if(x<=0 || y<=0 || x>= rightSideOfScreen || y>= bottomOfScreen)
        {
            turn(180);
        }
    }
}
