public enum DBConnect {
    //Constant to
    URL("jdbc:sqlserver://DESKTOP-C280F8T\\MSSQLSERVER;databaseName=FinalProjectInfoManagement"),
        USER("papers"),
            PASSWORD("papersarewhite");

    private String val;

    DBConnect(String val){
        this.val = val;
    }

    public String getDBConnect(){
        return val;
    }
}
