//import com.github.zipcodewilmington.casino.games.BingoGame.BingoBoard;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.List;
//
//public class BingoBoardTest {
//
//    @Test
//    public void testToString() {
//        final BingoBoard bingoBoard = new BingoBoard();
//
//        System.out.println(bingoBoard);
//    }
//
//    @Test
//    public void testIsWinnerColumn() {
//        //Given
//        for (Character letter : "BINGO".toCharArray()) {
//            final BingoBoard bingoBoard = new BingoBoard();
//            Assert.assertFalse(bingoBoard.isWinner());
//
//            //When
//            final List<String> bingoValuesToBeMarked = bingoBoard.getColumn(letter);
//            bingoValuesToBeMarked.forEach(bingoBoard::markBoard);
//
//            //Then
//            Assert.assertTrue(bingoBoard.isWinner());
//        }
//    }
//
//    @Test
//    public void testIsWinnerInRow() {
//        //Given
//        for (int bingoRow = 0; bingoRow < 5; bingoRow++) {
//            final BingoBoard bingoBoard = new BingoBoard();
//            Assert.assertFalse(bingoBoard.isWinner());
//
//            //When
//            final List<String> bingoValuesToBeMarked = bingoBoard.getRow(bingoRow);
//            bingoValuesToBeMarked.forEach(bingoBoard::markBoard);
//
//            //Then
//            Assert.assertTrue(bingoBoard.isWinner());
//        }
//    }
//
//    @Test
//    public void testGetColumn() {
//        //Given
//        final int expectedLength = 5;
//        final BingoBoard bingoBoard = new BingoBoard();
//
//        //When
//        for (Character bingoLetter : "BINGO".toCharArray()) {
//            final List<String> currentColumn = bingoBoard.getColumn(bingoLetter);
//
//            //Then
//            Assert.assertEquals(expectedLength, currentColumn.size());
//        }
//    }
//
//    @Test
//    public void testGetRow() {
//        //Given
//        BingoBoard bingoBoard = new BingoBoard();
//
//        //When
//        for (int i = 0; i < 5; i++) {
//            List<String> row = bingoBoard.getRow(i);
//            for (Character bingoLetter : "BINGO".toCharArray()) {
//                //Then
//                Assert.assertTrue(row.toString().contains(bingoLetter.toString()));
//            }
//
//        }
//    }
//
//    @Test
//    public void testGetMatrix() {
//        //Given
//        final int expectedLength = 5;
//        final BingoBoard bingoBoard = new BingoBoard();
//
//        //When
//        final List<List<String>> matrix = bingoBoard.getMatrix();
//        for (List<String> row : matrix) {
//            //Then
//            Assert.assertEquals(expectedLength, row.size());
//        }
//    }
//    }
//
