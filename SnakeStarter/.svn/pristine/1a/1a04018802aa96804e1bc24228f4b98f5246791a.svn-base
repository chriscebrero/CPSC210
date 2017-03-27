package ca.ubc.cs.cpsc210.snake.tests.model;

import ca.ubc.cs.cpsc210.snake.model.Cell;
import ca.ubc.cs.cpsc210.snake.model.Food;
import ca.ubc.cs.cpsc210.snake.model.SnakeGame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

// jUnit tests for Food class
public class FoodTest {
    private Food testFood;

    @Before
    public void runBefore() {
        testFood = new Food(new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2));
    }

    @Test
    public void testFood() {
        assertEquals(100, testFood.getNutritionalValue());
        assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2),testFood.getPosition());
        // use this as a template for designing your tests
    }

    @Test
    public void testFood2() {
        testFood = new Food((new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2)), 500);
        assertEquals(500, testFood.getNutritionalValue());
        assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2),testFood.getPosition());
        testFood.decay();
        assertEquals(490, testFood.getNutritionalValue());
    }

    @Test
    public void testFood3() {
        testFood = new Food((new Cell(3, 3)), 5);
        assertEquals(5, testFood.getNutritionalValue());
        assertEquals(new Cell(3,3),testFood.getPosition());
        testFood.decay();
        assertEquals(0, testFood.getNutritionalValue());
    }
}