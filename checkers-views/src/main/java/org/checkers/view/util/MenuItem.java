package org.checkers.view.util;

/**
 * Collected constants which should be used to create JMenuItems, and the same way, they can be
 * used in Controllers as a reference of JMenuItem object.
 */
public final class MenuItem {

  // Constant for File Menu
  public static final String MENU_FILE = "File";

  // Following constants should be used in FileMenu.
  public static final String FILE_NEW_GAME = "New Game";
  public static final String FILE_SAVE_GAME = "Save";
  public static final String FILE_LOAD_GAME = "Load";
  public static final String FILE_SAVE_REPLAY = "Save Replay";
  public static final String FILE_LOAD_REPLAY = "Load Replay";
  public static final String FILE_EXIT_GAME = "Exit";

  /**
   An object or class references the constants using MenuItem.FILE_NEW_GAME, and so on.
   Thus, the contructor is delared as private to prevent any construction call.
  */
  private MenuItem(){
    // Following line prevents even the native class from calling this constructor as well.
    throw new AssertionError();
  }
}
