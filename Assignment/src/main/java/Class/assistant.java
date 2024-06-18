/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

public class assistant {
    private int assistantID;
    private String assistantname;
    private String assistantmanager;
            
    public assistant() {
    }

    public assistant(int assistantID, String assistantname, String manager) {
        this.assistantID = assistantID;
        this.assistantname = assistantname;
        this.assistantmanager = manager;
    }

    public int getAssistantID() {
        return assistantID;
    }

    public void setAssistantID(int assistantID) {
        this.assistantID = assistantID;
    }

    public String getAssistantname() {
        return assistantname;
    }

    public void setAssistantname(String assistantname) {
        this.assistantname = assistantname;
    }

    public String getAssistantmanager() {
        return assistantmanager;
    }

    public void setAssistantmanager(String assistantmanager) {
        this.assistantmanager = assistantmanager;
    }

}
