package com.jjh.beans;

import org.springframework.context.Lifecycle;
import org.springframework.context.SmartLifecycle;

public class SampleBean implements Lifecycle, SmartLifecycle {

	private boolean running = false;
	public void start() {
		System.out.println("Lifecycle - start()");
		this.running = true;
	}

	public void stop() {
		System.out.println("Lifecycle - stop()");
		this.running = false;
	}

	public boolean isRunning() {
		System.out.println("Lifecycle - isRunning");
		return this.running;
	}

	public boolean isAutoStartup() {
		System.out.println("SmartLifecycle - isAutoStartup()");
		return false;
	}
	
	public void stop(Runnable callback) {
		System.out.println("SmartLifecycle - stop(Runnable()");
		SmartLifecycle.super.stop(callback);
	}
	
	public int getPhase() {
		System.out.println("SmartLifecycle - getPhase()");
		return DEFAULT_PHASE;
	}

}
