public class Main {
    public static class Department {
        protected int processTime;
        protected Department[] childDepartments;
        public Department(int processTime, Department[] childDepartments) {
            this.processTime = processTime;
            this.childDepartments = childDepartments;
        }
        public int totalProcessTime() {
            int maxChildTime = 0;
            for (Department child: this.childDepartments) {
                int childTime = child.totalProcessTime();
                if (childTime > maxChildTime)
                    maxChildTime = childTime;
            }
            return this.processTime + maxChildTime;
        }
    }
    public static void main(String[] args) {
        Department[] noChildren = new Department[0];
        Department[] depB0Children = {new Department(3, noChildren), new Department(4, noChildren)};
        Department[] depB1Children = {new Department(1, noChildren), new Department(2, noChildren), new Department(3, noChildren)};
        Department[] depB2Children = {new Department(5, noChildren)};
        Department[] depAChildren = {new Department(1, depB0Children), new Department(2, depB1Children), new Department(3, depB2Children)};
        Department depA = new Department(6, depAChildren);
        System.out.println(depA.totalProcessTime());
    }
}

