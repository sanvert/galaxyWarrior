Galaxy Warrior is a CLI based adventure game.<br />

To generate runnable jar artifact please run below maven command.<br />
Unit tests are run for each build.<br />

- mvn clean install<br />

- game.App is the main class.<br />

Game Manual<br />

   Meanings of signs on map<br />
        X - shows user character<br />
        W - shows enemies<br />
        / - blocked space<br />
        . - free space<br />
        
   Moving commands<br />
        w or W - Up<br />
        a or A - Left<br />
        s or S - Down<br />
        d or D - Right<br />
        save - saves current game<br />
        exit - to exit game<br />
        
        
   CLI View From Game<br />
   
   >s
   
   / / / / / / / / / / / / / / / / /<br />
   / . . . . . / . . . . . . . / . /<br />
   / . . . . . . . . . . . / . . / /<br />
   / . . . . / . . . . . . . . . . /<br />
   / . . . . . . . . . . . . . . . /<br /> 
   / . . . / . . / . . . . . . / . / <br />
   / / / . . . / / . . . . . . . . / <br />
   / . / . / . / / . / . . . / . . / <br />
   / . / / . X W . . . . . . . . . / <br />
   / . . . . . / / . . / . / . . . / <br />
   / . . . . . . . . / . . / / / . / <br />
   / . / / . . . . . . / . . . / W / <br />
   / . . . . . . . . . . / . . . . / <br />
   / . . . . . . . . / . . . . / . / <br />
   / . . . / . / . . / W . . . . . / <br />
   / . . . . . . W / . . . . / . . / <br />
   / / / / / / / / / / / / / / / / / <br />
   
   Right side a warrior is located<br />
   	Laser Shooter54 the Laser Shooter<br />
   	Life:125