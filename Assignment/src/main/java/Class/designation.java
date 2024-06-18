/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

public class designation {
    private int desigID;
    private String designame;
            
    public designation() {
    }

    public designation(int desigID, String designame) {
        this.desigID = desigID;
        this.designame = designame;
    }

    public int getDesigID() {
        return desigID;
    }

    public void setDesigID(int desigID) {
        this.desigID = desigID;
    }

    public String getDesigname() {
        return designame;
    }

    public void setDesigname(String designame) {
        this.designame = designame;
    }

}
