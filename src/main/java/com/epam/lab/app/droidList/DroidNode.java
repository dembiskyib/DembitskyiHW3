package com.epam.lab.app.droidList;

import java.util.Objects;

import com.epam.lab.app.droidList.droids.Droid;

public class DroidNode<T extends Droid> {
	private DroidNode<T> next;
	private DroidNode<T> previous;
	private T droid;

	public DroidNode(T droid) {
		this.droid = droid;
	}

	public DroidNode<T> getNext() {
		return next;
	}

	public void setNext(DroidNode<T> next) {
		this.next = next;
	}

	public T getDroid() {
		return droid;
	}

	public void setDroid(T droid) {
		this.droid = droid;
	}

	public DroidNode<T> getPrevious() {
		return previous;
	}

	public void setPrevious(DroidNode<T> previous) {
		this.previous = previous;
	}

	@Override
	public String toString() {
		if (Objects.isNull(previous) || Objects.isNull(next)) {
			return droid.toString();
		}
		return previous.getDroid().toString() + " -> " + droid + " -> " + next.getDroid().toString();
	}
}
