Galaxy Warrior is a CLI based adventure game.

To generate runnable jar artifact please run below maven command.
Unit tests are run for each build.

- mvn clean install

Game Manual

   Meanings of signs on map
        X - shows user character
        W - shows enemies
        / - blocked space
        . - free space
        
   Moving commands
        w or W - Up
        a or A - Left
        s or S - Down
        d or D - Right
        save - saves current game
        exit - to exit game
        
        
   CLI View From Game
   
   >s
   
   / / / / / / / / / / / / / / / / / 
   / . . . . . / . . . . . . . / . / 
   / . . . . . . . . . . . / . . / / 
   / . . . . / . . . . . . . . . . / 
   / . . . . . . . . . . . . . . . / 
   / . . . / . . / . . . . . . / . / 
   / / / . . . / / . . . . . . . . / 
   / . / . / . / / . / . . . / . . / 
   / . / / . X W . . . . . . . . . / 
   / . . . . . / / . . / . / . . . / 
   / . . . . . . . . / . . / / / . / 
   / . / / . . . . . . / . . . / W / 
   / . . . . . . . . . . / . . . . / 
   / . . . . . . . . / . . . . / . / 
   / . . . / . / . . / W . . . . . / 
   / . . . . . . W / . . . . / . . / 
   / / / / / / / / / / / / / / / / / 
   
   Right side a warrior is located
   	Laser Shooter54 the Laser Shooter
   	Life:125