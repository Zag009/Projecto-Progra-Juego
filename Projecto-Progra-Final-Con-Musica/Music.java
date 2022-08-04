import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Music here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Music extends Actor
{
    GreenfootSound myMusic = new GreenfootSound("y2mate.com - power flow  jaqueando tu amor video oficial.mp3");
    boolean firstTurn = true;
    public void act()
    {
        if(firstTurn)
        {
            myMusic.playLoop();
            firstTurn = false;
        }
        if(Greenfoot.mouseClicked(this))
        {
            if(myMusic.isPlaying())
            {
                myMusic.pause();
                setImage("pixil-frame-0 (4).png");
            } 
            else
            {
                myMusic.playLoop();
                setImage("pixil-frame-0 (3).png");
            }
        }
    
        
    }
}
