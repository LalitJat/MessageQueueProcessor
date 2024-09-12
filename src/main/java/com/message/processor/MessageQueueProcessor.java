package com.message.processor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MessageQueueProcessor {

    private static final Logger logger = LogManager.getLogger(MessageQueueProcessor.class);

    public static void main(String[] args) {

        // Initializing message queue and message processor
        MessageQueue messageQueue = new MessageQueue();
        MessageProcessor messageProcessor = new MessageProcessor(messageQueue);

        Producer producer = new Producer(messageQueue, 10);
        Consumer consumer = new Consumer(messageQueue, messageProcessor);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            Thread.sleep(2000);
            consumerThread.interrupt();
            consumerThread.join();
        } catch (InterruptedException e) {
            logger.error("InterruptedException while processing messages.", e);
        }

        logger.info("\nTotal Messages Processed Successfully: {}", messageProcessor.getSuccessCount());
        logger.info("Total Errors Encountered: {}", messageProcessor.getErrorCount());
        logger.info("--- MESSAGE QUEUE EXECUTION TASK COMPLETED ---\n");

    }
}
