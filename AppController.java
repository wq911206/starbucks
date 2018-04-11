

package starbucks ;

public class AppController implements IApp
{

    private IScreen mycards ;
    private IScreen store ;
    private IScreen rewards ;
    private IScreen payments ;
    private IMenuCommand displayMyCards ;
    private IMenuCommand displayPayments ;
    private IMenuCommand displayRewards ;
    private IMenuCommand doStore ;    
    private IFrame frame ;

    public AppController()
    {
        mycards = new MyCards() ;
        store = new Store() ;
        rewards = new Rewards() ;
        payments = new Payments() ;
        frame = new Frame( mycards ) ;
                
        // setup command pattern
        displayMyCards  = new MenuCommand() ;
        displayPayments = new MenuCommand() ;
        displayRewards  = new MenuCommand() ;
        doStore         = new MenuCommand() ;
        displayMyCards.setReceiver(
            new IMenuReceiver() {
                public void doAction() {
                    frame.setCurrentScreen( mycards ) ;
                }
            }
        ) ;
        displayPayments.setReceiver(
            new IMenuReceiver() {
                public void doAction() {
                    frame.setCurrentScreen( payments ) ;
                }
            }
        ) ;
        displayRewards.setReceiver(
            new IMenuReceiver() {
                public void doAction() {
                    frame.setCurrentScreen( rewards ) ;
                }
            }
        ) ;
        doStore.setReceiver(
            new IMenuReceiver() {
                public void doAction() {
                    frame.setCurrentScreen( store ) ;
                }
            }
        ) ;        
        frame.setMenuItem ( "A", displayMyCards ) ;
        frame.setMenuItem ( "B", displayPayments ) ;
        frame.setMenuItem ( "C", displayRewards ) ;
        frame.setMenuItem ( "D", doStore ) ;
    }

        
   public void landscape() 
   { 
      frame.landscape() ; 
   }
   
   public void portrait()  
   { 
      frame.portrait() ; 
   }      
    
   public void touch(int x, int y)
   {
        frame.touch(x,y) ;
   }
    
   public void display()
    {
        frame.display() ;
    }
    
    public void execute( String c )
    {
        frame.cmd( c ) ;
    }

    public void prev() {
        // add code here
    }
    
    public void next() {
        // add code here
    }
    
    public String screen() {
        return frame.screen() ;
    }
    
    public String screenContents() {
        return frame.contents() ;
    }
}
