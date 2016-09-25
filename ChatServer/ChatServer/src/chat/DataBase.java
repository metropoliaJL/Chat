/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Joonas
 */
public class DataBase implements Observable{
    private final ArrayList<Message> chatHistory;
    private final Set<Observer> observers;
    private String currentObserver;
    private static DataBase instance = null;
    
    protected DataBase() {
        this.chatHistory = new ArrayList<>();
        this.observers = new HashSet();
        this.currentObserver = "";
    }
    
    public static DataBase getInstance(){
        if(instance == null) {
            instance = new DataBase();
        } 
        return instance;
    }
        
    public void appendHistory(Message m){
        chatHistory.add(m);
    }

    public ArrayList<Message> getChatHistory() {
        return chatHistory;
    }

    public Set<Observer> getObservers() {
        return this.observers;
    }
    

    public void setCurrentObserver(String currentObserver) {
        this.currentObserver = currentObserver;
    }

    public String getCurrentObserver() {
        return this.currentObserver;
    }

    @Override
    public void register(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void deregister(Observer o) {
        this.observers.remove(o);
    }

    @Override
    public void notifyObservers(Message m) {
        for(Observer o : this.observers) {
            o.update(m);
        }
    }
    
        
}