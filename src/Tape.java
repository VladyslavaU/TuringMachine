public class Tape {
    private Cell currentCell;

    public Tape() {
        this.currentCell = new Cell();

    }

    public Cell getCurrentCell() {
        return this.currentCell;
    }

    public char getContent() {
        return this.currentCell.content;
    }

    public void setContent(char ch) {
        this.currentCell.content = ch;
    }

    public void moveLeft() {
        if (this.currentCell.prev == null) {
            Cell temp = new Cell();
            temp.next = this.currentCell;
            this.currentCell.prev = temp;
            this.currentCell = temp;
        } else {
            this.currentCell = this.currentCell.prev;
        }
    }

    public void moveRight() {
        if (this.currentCell.next == null) {
            Cell temp = new Cell();
            temp.prev = this.currentCell;
            this.currentCell.next = temp;
            this.currentCell = temp;
        } else {
            this.currentCell = this.currentCell.next;
        }
    }

    public String getTapeContents() {
        while (this.currentCell.prev != null) {
            moveLeft();
        }
        StringBuilder tape = new StringBuilder();
        while (this.currentCell.next != null) {
            tape.append(this.getContent());
            moveRight();
        }
        return tape.toString();
    }


}

