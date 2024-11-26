package it.unibo.design.robot.components.api;

/**
 * A collection of {@link RobotPart}. Parts can be added and removed. This
 * collection has an iterator, namely it allows other classes to run through its
 * elements. There is no guarantee on ordering.
 * 
 */
public interface RobotPartCollection {

    /**
     * Adds a new {@link RobotPart}.
     * 
     * @param robotPart
     *            the {@link RobotPart} to add
     */
    void add(RobotPart robotPart);

    /**
     * Resets the iterator.
     */
    void resetIterator();

    /**
     * @return true if the iterator has more elments
     */
    boolean hasAnotherPart();

    /**
     * Retrieves the current {@link RobotPart} and moves the iterator forward.
     * 
     * @return the current {@link RobotPart}, or null if there is none.
     */
    RobotPart next();

    /**
     * Removes a {@link RobotPart}.
     * 
     * @param robotPart the {@link RobotPart} to remove
     */
    void remove(RobotPart robotPart);

}
