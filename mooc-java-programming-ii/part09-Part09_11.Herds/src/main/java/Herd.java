import java.util.ArrayList;
import java.util.List;

public class Herd implements Movable {
    private List<Movable> members;

    public Herd() {
        this.members = new ArrayList<>();
    }

    public void addToHerd(Movable movable) {
        this.members.add(movable);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Movable member : this.members) {
            sb.append(member.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable member : this.members) {
            member.move(dx, dy);
        }
    }
}
