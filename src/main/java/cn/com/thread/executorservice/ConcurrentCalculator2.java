package cn.com.thread.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ConcurrentCalculator2 {

	private int cpuCoreNumber;
	private ExecutorService exec;
	private List<Future<Long>> tasks = new ArrayList<>();

	class SumCalculator implements Callable<Long> {
		private int[] numbers;
		private int start;
		private int end;

		public SumCalculator(int[] numbers, int start, int end) {
			this.numbers = numbers;
			this.start = start;
			this.end = end;
		}

		@Override
		public Long call() throws Exception {
			Long restult = 0l;
			for (int i = start; i < end; i++) {
				restult += numbers[i];
			}

			return restult;
		}

	}

	public ConcurrentCalculator2() {
		cpuCoreNumber = Runtime.getRuntime().availableProcessors();
		System.out.println(cpuCoreNumber);
		exec = Executors.newFixedThreadPool(cpuCoreNumber);
	}

	public Long sum(final int[] numbers) {
		int increment = (numbers.length-1+cpuCoreNumber) / cpuCoreNumber;//少计算一次
		System.out.println(increment);
		for (int i = 0; i < cpuCoreNumber; i++) {
			int start = increment * i;
			System.out.println(start+"--");
			int end = increment * i + increment;
			System.out.println(end+"---");
			if (end > numbers.length) {
				end = numbers.length;
			}
			FutureTask<Long> task = new FutureTask<>(new SumCalculator(numbers, start, end));
			tasks.add(task);
			if (!exec.isShutdown()) {
				exec.submit(task);
			}
		}
		return getResult();
	}

	public Long getResult() {
		Long result = 0l;
		for (Future<Long> future : tasks) {
			try {
				result += future.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8};
		ConcurrentCalculator2 calc = new ConcurrentCalculator2();
		Long sum = calc.sum(numbers);
		System.out.println(sum);
		calc.close();
	}

	private void close() {
		exec.isShutdown();

	}
}