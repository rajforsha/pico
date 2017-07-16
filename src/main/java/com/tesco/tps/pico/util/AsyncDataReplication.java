package com.tesco.tps.pico.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.beans.factory.annotation.Autowired;

import com.tesco.tps.pico.domain.Domain;
import com.tesco.tps.pico.repository.DocumentElasticsearchRepository;

/**
 * @author shashi
 *
 */
public class AsyncDataReplication {

	@Autowired
	private static DocumentElasticsearchRepository elasticsearchRepo;

	@SuppressWarnings("unchecked")
	public static BlockingDeque<Domain> queue = (BlockingDeque<Domain>) new ArrayBlockingQueue<Domain>(100);
	public static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

	public static void replicateDataToOtherDatabase() {

		Domain data = null;
		try {
			data = queue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			elasticsearchRepo.save(data);
		} catch (Exception e) {
			try {
				queue.put(data);// again putting to queue
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

	}

	static {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				while (true) {
					replicateDataToOtherDatabase();
				}
			}
		};
		executor.execute(r);
	}
}
