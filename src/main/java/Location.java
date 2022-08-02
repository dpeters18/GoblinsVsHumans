public class Location {
    private int row;
    private int col;

    public Location(int row, int col)
    {
        this.row=row;
        this.col=col;
    }
    public int getRow(){return row;}

    public int getCol(){return col;}

    public void setRow(int row){this.row=row;}

    public void setCol(int col){this.col=col;}

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Location&&row==((Location) obj).getRow()&&col==((Location) obj).getCol();
    }

    @Override
    public String toString(){return ""+row+","+col+"";}

}
