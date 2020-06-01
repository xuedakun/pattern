package cn.com.queue;

/**
 * 消费实体
 */
public class Task {
    public  int no;

    public Task(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Task{" +
                "no=" + no +
                '}';
    }
}
