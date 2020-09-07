package hot100.exercise0621;

/*
给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。
任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。
CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，
因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
你需要计算完成所有任务所需要的最短时间。
示例 ：
输入：tasks = ["A","A","A","B","B","B"], n = 2
输出：8
解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
     在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，
     而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
提示：
任务的总个数为 [1, 10000]。
n 的取值范围为 [0, 100]。
 */

import java.util.Arrays;

/**
 * 思路：
 * 先统计出每种类型的任务各有多少个，
 * 然后将得到的结果排序，
 * 然后首先排数量最多的任务，
 * 排完最多的任务后，开始排第二多，第三多，，，
 *
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        //计算每种任务出现的次数
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        //将任务按照多少进行排序
        Arrays.sort(map);
        //按照最多任务的数量，计算最多的等待时间
        int max_val = map[25] - 1, idle_slots = max_val * n;
        //向等待时间中添加任务，
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            idle_slots -= Math.min(map[i], max_val);
        }
        //如果等待时间小于0，则说明通过合理安排，可以使CPU不需要等待，因此执行用时就是tasks长度
        //如果等待时间大于0，则执行用时就是tasks长度加上等待用时。
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }
}
