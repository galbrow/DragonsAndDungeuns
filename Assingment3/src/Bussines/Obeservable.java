package Bussines;

public interface Obeservable {
    void addObserver(Observer o);
    void notifyObservers(char x);
}
