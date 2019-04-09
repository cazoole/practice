package com.example.demo.dynamic;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class FileWatchService {

    public static void main(String[] args) throws IOException {
        watchService();
    }

    public static void watchService() throws FileNotFoundException {
        final Path path = ResourceUtils.getFile("classpath:").toPath();

        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
            while (true) {
                final WatchKey key = watchService.take();
                for (WatchEvent<?> watchEvent : key.pollEvents()) {
                    final WatchEvent.Kind kind = watchEvent.kind();
                    if(kind == StandardWatchEventKinds.OVERFLOW) {
                        System.out.println("overflow  continue...");
                        continue;
                    }

                    if(kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                        System.out.println("修改");
//                        readFile();
                    }

                    final WatchEvent<Path> pathWatchEvent = (WatchEvent<Path>) watchEvent;
                    final Path fileName = pathWatchEvent.context();
                    System.out.println(pathWatchEvent.context().getRoot());
                    System.out.println(String.format("key = %s，kind=%s， fileName = %s", key, kind, fileName.getFileName()));
                }
                if(!key.reset()){
                    break;
                }
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


    }

    public static void readFile() throws FileNotFoundException {
        ClassPathResource resource = new ClassPathResource("watch.txt");

        // final Path path = Paths.get("watch.txt");
//        final Path path = resource.getFile().toPath();
        final File file = ResourceUtils.getFile("classpath:watch.txt");
        Path path = file.toPath();
        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)){
            int lineCount = 0;
            String line = br.readLine();
            for(;StringUtils.isNoneBlank(line); line=br.readLine()) {
                System.out.println(String.format("第%d行：%s", lineCount++, line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
