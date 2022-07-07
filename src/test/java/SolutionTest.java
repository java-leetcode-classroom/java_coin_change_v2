import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
  final private  Solution sol = new Solution();
  @Test
  void changeExample1() {
    assertEquals(4, sol.change(5,new int[]{1,2,5}));
  }
  @Test
  void changeExample2() {
    assertEquals(0, sol.change(3,new int[]{2}));
  }
  @Test
  void changeExample3() {
    assertEquals(1, sol.change(10,new int[]{10}));
  }

  @Test
  void changeV2Example1() {
    assertEquals(4, sol.changeV2(5,new int[]{1,2,5}));
  }
  @Test
  void changeV2Example2() {
    assertEquals(0, sol.changeV2(3,new int[]{2}));
  }
  @Test
  void changeV2Example3() {
    assertEquals(1, sol.changeV2(10,new int[]{10}));
  }

  @Test
  void changeDFSExample1() {
    assertEquals(4, sol.changeDFS(5,new int[]{1,2,5}));
  }
  @Test
  void changeDFSExample2() {
    assertEquals(0, sol.changeDFS(3,new int[]{2}));
  }
  @Test
  void changeDFSExample4() {
    assertEquals(1, sol.changeDFS(10,new int[]{10}));
  }
}