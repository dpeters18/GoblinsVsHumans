public class Shield implements ItemDrop {
    int numhits=3;
    public void effect(Object obj,Object objj){
        numhits--;
    }
    public int getNumHits(){
        return numhits;
    }
}
