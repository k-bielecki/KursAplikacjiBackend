package pl.nullpointerexception.shop.admin.product.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ExistingFileRenameUtilsTest {

    @Test
    void shouldNotRenameExistingFiles(@TempDir Path tempDir) {
        String newName = ExistingFileRenameUtils.renameIfExist(tempDir, "test.txt");
        assertEquals("test.txt", newName);
    }

    @Test
    void shouldRenameExistingFiles(@TempDir Path tempDir) throws IOException {
        Files.createFile(tempDir.resolve("test.txt"));
        String newName = ExistingFileRenameUtils.renameIfExist(tempDir, "test.txt");
        assertEquals("test-1.txt", newName);
    }

    @Test
    void shouldRenameManyExistingFiles(@TempDir Path tempDir) throws IOException {
        Files.createFile(tempDir.resolve("test.txt"));
        Files.createFile(tempDir.resolve("test-1.txt"));
        Files.createFile(tempDir.resolve("test-2.txt"));
        Files.createFile(tempDir.resolve("test-3.txt"));
        String newName = ExistingFileRenameUtils.renameIfExist(tempDir, "test.txt");
        assertEquals("test-4.txt", newName);
    }

}