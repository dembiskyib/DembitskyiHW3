package com.epam.lab.app.droidList;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.lab.app.droidList.droids.Droid;

public class DroidLinkedList<T extends Droid> {
	private static final Logger logger = LogManager.getLogger(DroidLinkedList.class);
	private DroidNode<T> first;
	private DroidNode<T> last;

	public void add(T droid) {
		DroidNode<T> tempDroidNode = new DroidNode<>(droid);
		if (first == null) {
			first = tempDroidNode;
			last = first;
		} else if (first == last) {
			last = tempDroidNode;
			last.setPrevious(first);
			first.setNext(last);
		} else {
			last.setNext(tempDroidNode);
			tempDroidNode.setPrevious(last);
			last = tempDroidNode;
		}
	}

	public T get(int number) {
		DroidNode<T> currentNode = first;
		int currentNumber = 0;
		while (currentNode != null) {
			if (currentNumber == number) {
				return currentNode.getDroid();
			}
			currentNode = currentNode.getNext();
			currentNumber++;
		}
		return null;
	}

	public void remove(int number) {
		DroidNode<T> currentNode = first;
		int currentNumber = 0;
		while (currentNode != null) {
			if (currentNumber == number) {
				if (currentNode == first) {
					currentNode.getNext().setPrevious(null);
					first = currentNode.getNext();
				} else if (currentNode == last) {
					currentNode.getPrevious().setNext(null);
					last = currentNode;
				} else {
					currentNode.getNext().setPrevious(currentNode.getPrevious());
					currentNode.getPrevious().setNext(currentNode.getNext());
				}
			}
			currentNode = currentNode.getNext();
			currentNumber++;
		}
	}

	public void print() {
		if (Objects.nonNull(first)) {
			for (DroidNode<T> currentNode = first; currentNode != last; currentNode = currentNode.getNext()) {
				logger.info(currentNode.getDroid().getSerialNumber());
			}
			logger.info(last.getDroid().getSerialNumber());
		}
	}

	@SuppressWarnings("unused")
	private int checkSize() {
		DroidNode<T> currentNode = first;
		int size = 1;
		while (currentNode != last) {
			currentNode = currentNode.getNext();
			size++;
		}
		return size;
	}

	public T getFirst() {
		return first.getDroid();
	}

	public T getLast() {
		return last.getDroid();
	}

}
