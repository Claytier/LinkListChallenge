package com.company;

import java.util.*;

public class Main {

    private static ArrayList<Albums> albums = new ArrayList<Albums>();

    public static void main(String[] args) {
        Albums album = new Albums("Stormbreaker", "Deep Purple");
        album.addSong("stormbreaker", 3.10);
        album.addSong("stormbreaker2", 3.20);
        album.addSong("stormbreaker3", 3.30);
        album.addSong("stormbreaker4", 3.40);
        album.addSong("stormbreaker5", 3.50);
        album.addSong("stormbreaker6", 3.16);
        album.addSong("stormbreake7r", 3.17);
        album.addSong("stormbreaker8", 3.18);
        album.addSong("stormbreaker9", 3.19);
        ;
        albums.add(album);

        album = new Albums("for those about to rock", "AC/DC");
        album.addSong("storm1", 3.11);
        album.addSong("storm2", 3.12);
        album.addSong("storm3", 3.13);
        album.addSong("storm4", 3.14);
        album.addSong("storm5", 3.15);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlaylist("stormbreaker", playList);
        albums.get(0).addToPlaylist("stormbreaker2", playList);
        albums.get(0).addToPlaylist("stormreaker00", playList);
        albums.get(1).addToPlaylist(2, playList);
        albums.get(1).addToPlaylist(3, playList);

        play(playList);


    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now Playing " + listIterator.next().toString());
            printMenu();
        }
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist is complete");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("Reached end of playlist");
                        forward = false;
                    }

                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("Reached start of playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous());
                            forward = false;
                        } else {
                            System.out.println("yau are at start of list");
                        }
                    } else {
                        if(listIterator.hasNext()) {
                            System.out.println("Now Replaying " + listIterator.next());
                            forward = true;
                        } else {
                            System.out.println("you have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size() > 0) {
                        listIterator.remove();
                        if(listIterator.hasNext()) {
                            //listIterator.next();
                            System.out.println("Now playing "+ listIterator.next().toString());
                        }
                    } else if(listIterator.hasPrevious()) {
                        //listIterator.previous();
                        System.out.println("Now palying " + listIterator.previous());
                } break;

            }
        }

    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to leave\n"
                + "1 - next song\n" +
                "2 - previous song\n" +
                "3 - Replay current song\n" +
                "4 - List playlist\n" +
                "5 - print menu\n" +
                "6 - delete current song");
    }
    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("==========");
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("========");
    }
}
