package com.algograph;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Arrays;

public class AlgoHandler extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        String response;

        if (message.startsWith("/start")) {
            response = "👋 Welcome to AlgoGraphBot!\nChoose one: `searching` or `sorting`.\nFormat:\n" +
                       "`/searching linear 4 1 2 3 4 target`\n" +
                       "`/sorting bubble 5 5 3 4 1 2`";
        } else if (message.startsWith("/searching")) {
            response = handleSearching(message);
        } else if (message.startsWith("/sorting")) {
            response = handleSorting(message);
        } else {
            response = " Invalid command.\nTry `/start` to see options.";
        }

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        sendMessage.setText(response);
        sendMessage.enableMarkdown(true);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private String handleSearching(String msg) {
        try {
            String[] parts = msg.split(" ");
            String type = parts[1];
            int n = Integer.parseInt(parts[2]);
            int[] arr = Arrays.stream(Arrays.copyOfRange(parts, 3, 3 + n))
                              .mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(parts[3 + n]);

            int index;
            String def;

            if (type.equals("linear")) {
                def = "Linear Search: checks each element one by one.";
                index = Searching.linearSearch(arr, target);
            } else if (type.equals("binary")) {
                Arrays.sort(arr);
                def = "Binary Search: works on sorted arrays by dividing.";
                index = Searching.binarySearch(arr, target);
            } else return "Unknown search type: `" + type + "`";

            return "*" + def + "*\nArray: " + Arrays.toString(arr) +
                   "\nTarget: " + target +
                   "\nResult: " + (index == -1 ? "Not found." : "Found at index " + index);
        } catch (Exception e) {
            return " Invalid format. Use `/searching linear 4 1 2 3 4 target`";
        }
    }

    private String handleSorting(String msg) {
        try {
            String[] parts = msg.split(" ");
            String type = parts[1];
            int n = Integer.parseInt(parts[2]);
            int[] arr = Arrays.stream(Arrays.copyOfRange(parts, 3, 3 + n))
                              .mapToInt(Integer::parseInt).toArray();

            String def;

            switch (type) {
                case "bubble" -> {
                    def = "Bubble Sort: swaps adjacent elements.";
                    Sorting.bubbleSort(arr);
                }
                case "selection" -> {
                    def = "Selection Sort: selects min each time.";
                    Sorting.selectionSort(arr);
                }
                case "insertion" -> {
                    def = "Insertion Sort: builds sorted list gradually.";
                    Sorting.insertionSort(arr);
                }
                case "merge" -> {
                    def = "Merge Sort: divide and conquer.";
                    Sorting.mergeSort(arr, 0, arr.length - 1);
                }
                case "quick" -> {
                    def = "Quick Sort: partitions and recurses.";
                    Sorting.quickSort(arr, 0, arr.length - 1);
                }
                default -> {
                    return " Unknown sort: `" + type + "`";
                }
            }

            return "*" + def + "*\nSorted Array: " + Arrays.toString(arr);
        } catch (Exception e) {
            return " Invalid format. Use `/sorting bubble 5 5 4 3 2 1`";
        }
    }

    @Override
    public String getBotUsername() {
        return System.getenv("BOT_USERNAME");
    }

    @Override
    public String getBotToken() {
        return System.getenv("BOT_TOKEN");
    }
}
