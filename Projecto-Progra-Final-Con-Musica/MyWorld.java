import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    //Animales
    static final int MAX_MOUSE = 5;
    static final int MIN_MOUSE = 3;

    // Monstruos
    static final int MAX_MOMIA = 1;
    static final int MIN_MOMIA = 1;
    static final int MAX_ZOMBIE = 1;
    static final int MIN_ZOMBIE = 1;

    // Power ups
    static final int MAX_SPEED = 1;
    static final int MIN_SPEED = 1;

    static final int INTERVAL = 40;
    Long beginTime = System.currentTimeMillis();
    private Jugador ppl1;
    
    private Actor timerDisplay = new SimpleActor();
    private int timeElapsed;
    private int timeCounter;
    
    
    public MyWorld()
    {    

        super(550, 550, 1); 

        ppl1 = new Jugador();
        addObject (ppl1, 275, 275);
        GreenfootSound myMusic = new GreenfootSound("y2mate.com - power flow  jaqueando tu amor video oficial.mp3");
        //myMusic.playLoop();
        
        updateTimerDisplay();
        addObject(timerDisplay, 500, 30);
        prepare();
    }

    public void act()
    {
        addRandomMouse();   
        speed();
        Zombie();
        Momia();
        Ghost();
        addRandomBat();

        if (Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new MyWorld());
        }
        
        timeCounter = (timeCounter+1)%55;
        if(timeCounter == 0)
        {
            timeElapsed++;
            updateTimerDisplay();
        }
    }
    
    private void updateTimerDisplay()
    {
        timerDisplay.setImage(new GreenfootImage("Time: "+timeElapsed, 24, null, null));
    }

    public void speed()
    {
        if( Greenfoot.getRandomNumber(1000) < 1)
        {
            for (int x = 0; x < Greenfoot.getRandomNumber(MAX_SPEED + 1 - MIN_SPEED) + MIN_SPEED; x++)
                addObject(new Speed(), Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
        }
    }

    public void MouseTime()
    {
        if ((System.currentTimeMillis() - beginTime)/1000 >= INTERVAL)
        {
            addRandomMouse();
            beginTime = System.currentTimeMillis();
        }
    }

    public void addRandomMouse()
    {
        if(Greenfoot.getRandomNumber(100)==10)
        {
            int x = Greenfoot.getRandomNumber(400);
            int y = Greenfoot.getRandomNumber(400);

            addObject(new Mouse(), x, y);
        }
    }

    public void BatTime()
    {
        if ((System.currentTimeMillis() - beginTime)/1500 >= INTERVAL)
        {
            addRandomBat();
            beginTime = System.currentTimeMillis();
        }
    }

    public void addRandomBat()
    {
        if(Greenfoot.getRandomNumber(100)==5)
        {
            int x = Greenfoot.getRandomNumber(400);
            int y = Greenfoot.getRandomNumber(400);

            addObject(new Bat(), x, y);
        }
    }

    public void Momia()
    {
        if( Greenfoot.getRandomNumber(2000) < 4)
        {
            for (int x = 0; x < Greenfoot.getRandomNumber(MAX_MOMIA + 1 - MIN_MOMIA) + MIN_MOMIA; x++)
                addObject(new Momia(), Greenfoot.getRandomNumber(400), Greenfoot.getRandomNumber(400));
        }
    }

    public void Zombie()
    {
        if( Greenfoot.getRandomNumber(3000) < 3)
        {
            for (int x = 0; x < Greenfoot.getRandomNumber(MAX_ZOMBIE + 1 - MIN_ZOMBIE) + MIN_MOMIA; x++)
                addObject(new Zombie(), Greenfoot.getRandomNumber(400), Greenfoot.getRandomNumber(400));
        }
    }

    public void Ghost()
    {
        if( Greenfoot.getRandomNumber(2500) < 2)
        {
            for (int x = 0; x < Greenfoot.getRandomNumber(MAX_ZOMBIE + 1 - MIN_ZOMBIE) + MIN_MOMIA; x++)
                addObject(new Ghost(), Greenfoot.getRandomNumber(400), Greenfoot.getRandomNumber(400));
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Counter counter = new Counter();
        addObject(counter,48,18);
        Music music = new Music();
        addObject(music,46,62);
    }
}

