package logic;

public class Fighter extends Piece {
    // field
    private boolean promoted;
    private PositionList promotedMovePositions;

    // constructor
    public Fighter(int initialPositionX, int initialPositionY, boolean reverse, String name) {
        super(initialPositionX, initialPositionY, reverse, name);
        movePositions.add(-1, 2);
        movePositions.add(1, 2);
        promotedMovePositions = new PositionList();
        promotedMovePositions.add(0, 2);
        promotedMovePositions.add(1, 0);
        promotedMovePositions.add(0, -2);
        promotedMovePositions.add(-1, 0);

        if (isReverse()) {
            for (Position p : promotedMovePositions) p.reverse();
            for (Position p : movePositions) p.reverse();
        }
        setPromoted(false);
    }

    // method
    public void move(int movePattern) {
        Position moving = (!promoted) ? movePositions.get(movePattern) : promotedMovePositions.get(movePattern);
        Position newPos = getCurrentPosition().addPositionValue(moving);

        setCurrentPosition(newPos);
        this.getCurrentPosition().normalizedPosition();;
    }

    public Position attackTargetPosition(int actionPattern) {
        Position moving = movePositions.get(actionPattern);
        Position targetPos = getCurrentPosition().addPositionValue(moving);
        targetPos.normalizedPosition();
        setCurrentPosition(targetPos);
        return targetPos;
    }

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public PositionList getPromotedMovePositions() {
        return promotedMovePositions;
    }
}
