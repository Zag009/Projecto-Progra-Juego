import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Jugador extends Actor
{
    GreenfootImage myImage = getImage();
    private int mouseCatched;
    public int move = 3;
    //public int size1 = (int)myImage.getHeight()/1;
    //public int size2 = (int)myImage.getWidth()/1;
    private int speedTimer;
    private int sizeTimer;
    private int counter = 0;
    
    
    public Jugador()
    {
        mouseCatched = 0;
        
    }

    public void act()
    {

        runSpeedTimer();
        //runSizeTimer();
        checkKeypress();
        lookForMouse();
        lookForBat();
        lookForSpeed();
        hitMomia();
        hitZombie();
        hitGoo();
        hitGhost();

    }

    public void checkKeypress()
    {

        if (Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(), getY()-move);
        }
        if (Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(), getY()+move);
        }
        if (Greenfoot.isKeyDown("a"))
        {
            setLocation(getX()-move, getY());
        }
        if (Greenfoot.isKeyDown("d"))
        {
            setLocation(getX()+move, getY());
        }
    }

    private void runSpeedTimer()
    {
        if(speedTimer>0 && --speedTimer==0)
        {
            move = 3;
        }
    }

    private void runSizeTimer()
    {
        if(sizeTimer>0 && --sizeTimer==0)
        {
            //size1 = (int)myImage.getHeight()/1;
            //size2 = (int)myImage.getWidth()/1;
        }
    }

    public void lookForMouse()
    {
        if (isTouching(Mouse.class))
        {
            removeTouching(Mouse.class);
            Counter counter = (Counter)getWorld().getObjects(Counter.class).get(0);
            counter.add(1);
        }
    } 
    
    public void lookForBat()
    {
        if (isTouching(Bat.class))
        {
            removeTouching(Bat.class);
            Counter counter = (Counter)getWorld().getObjects(Counter.class).get(0);
            counter.add(3);
        }
    }

    public void lookForSpeed()
    {
        if (isTouching(Speed.class))
        {
            removeTouching(Speed.class);
            speedTimer=500;
            move = 8;
        }
    }

    public void hitMomia()
    {
        if(isTouching(Momia.class))
        {
            World myWorld = getWorld();
            GameOver gameover = new GameOver();
            myWorld.addObject(gameover, 275, 275);
            Restart restart = new Restart();
            myWorld.addObject(restart, 275, 400);
            getImage().setTransparency(0);
        }
    }
    public void hitZombie()
    {
        if(isTouching(Zombie.class))
        {
            World myWorld = getWorld();
            GameOver gameover = new GameOver();
            myWorld.addObject(gameover, 275, 275);
            Restart restart = new Restart();
            myWorld.addObject(restart, 275, 400);
            getImage().setTransparency(0);
        }
    }
    public void hitGoo()
    {
        if(isTouching(Goo.class))
        {
            World myWorld = getWorld();
            GameOver gameover = new GameOver();
            myWorld.addObject(gameover, 275, 275);
            Restart restart = new Restart();
            myWorld.addObject(restart, 275, 400);
            getImage().setTransparency(0);
        }
    }

    public void hitGhost()
    {
        if(isTouching(Ghost.class))
        {
            World myWorld = getWorld();
            GameOver gameover = new GameOver();
            myWorld.addObject(gameover, 275, 275);
            Restart restart = new Restart();
            myWorld.addObject(restart, 275, 400);
            getImage().setTransparency(0);
        }
    }
}