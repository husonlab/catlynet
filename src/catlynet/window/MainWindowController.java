package catlynet.window;

import javafx.beans.InvalidationListener;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCharacterCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jloda.fx.control.SplittableTabPane;
import jloda.fx.control.ZoomableScrollPane;
import jloda.fx.window.IMainWindow;
import jloda.fx.window.MainWindowManager;
import jloda.util.ProgramProperties;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu fileMenu;

    @FXML
    private MenuItem newMenuItem;

    @FXML
    private MenuItem openMenuItem;

    @FXML
    private MenuItem importMenuItem;

    @FXML
    private Menu exportMenu;

    @FXML
    private MenuItem exportSelectedNodesMenuItem;

    @FXML
    private MenuItem exportListOfReactionsMenuItem;

    @FXML
    private Menu recentFilesMenu;

    @FXML
    private MenuItem saveMenItem;

    @FXML
    private MenuItem pageSetupMenuItem;

    @FXML
    private MenuItem printMenuItem;

    @FXML
    private MenuItem closeMenuItem;

    @FXML
    private MenuItem quitMenuItem;

    @FXML
    private Menu editMenu;

    @FXML
    private MenuItem undoMenuItem;

    @FXML
    private MenuItem redoMenuItem;

    @FXML
    private MenuItem cutMenuItem;

    @FXML
    private MenuItem copyMenuItem;

    @FXML
    private MenuItem pasteMenuItem;

    @FXML
    private MenuItem clearMenuItem;

    @FXML
    private MenuItem findMenuItem;

    @FXML
    private MenuItem findAgainMenuItem;

    @FXML
    private MenuItem selectAllMenuItem;

    @FXML
    private MenuItem selectNoneMenuItem;

    @FXML
    private MenuItem selectInvertedMenuItem;

    @FXML
    private MenuItem selectNodesMenuItem;

    @FXML
    private MenuItem selectEdgesMenuItem;

    @FXML
    private Menu selectReactionSystemMenu;

    @FXML
    private MenuItem selectFoodMenuItem;

    @FXML
    private MenuItem selectMoleculesMenuItem;

    @FXML
    private MenuItem selectReactionsMenuItem;

    @FXML
    private MenuItem selectConnectedComponentMenuItem;

    @FXML
    private MenuItem selectFromPreviousWindowMenuItem;

    @FXML
    private Menu algorithmMenu;

    @FXML
    private MenuItem computeVisualizationMenuItem;

    @FXML
    private MenuItem runCAFMenuItem;

    @FXML
    private MenuItem runRAFMenuItem;

    @FXML
    private MenuItem runPseudoRAFMenuItem;

    @FXML
    private MenuItem runMenuItem;

    @FXML
    private MenuItem runMuCAFMenuItem;

    @FXML
    private MenuItem runURAFMenuItem;

    @FXML
    private MenuItem runMinIrrRAFMenuItem;

    @FXML
    private MenuItem runTrivialCAFsAlgorithmMenuItem;

    @FXML
    private MenuItem runTrivialRAFsAlgorithmMenuItem;

    @FXML
    private MenuItem runQuotientRAFMenuItem;

    @FXML
    private MenuItem runCoreRAFMenuItem;

    @FXML
    private MenuItem removeTrivialRAFsAlgorithmMenuItem;

    @FXML
    private MenuItem runMuCAFMultipleTimesMenuItem;

    @FXML
    private MenuItem spontaneousInRafMenuItem;

    @FXML
    private MenuItem greedyGrowMenuItem;


    @FXML
    private CheckMenuItem computeImportanceCheckMenuItem;

    @FXML
    private MenuItem graphEmbedderIterationsMenuItem;

    @FXML
    private CheckMenuItem animateCAFCheckMenuItem;

    @FXML
    private CheckMenuItem animateRAFCheckMenuItem;

    @FXML
    private CheckMenuItem animateMaxRAFCheckMenuItem;

    @FXML
    private CheckMenuItem animateInhibitionsMenuItem;

    @FXML
    private MenuItem stopAnimationMenuItem;

    @FXML
    private MenuItem increaseFontSizeMenuItem;

    @FXML
    private MenuItem decreaseFontSizeMenuItem;


    @FXML
    private MenuItem zoomInMenuItem;

    @FXML
    private MenuItem zoomOutMenuItem;

    @FXML
    private MenuItem zoomToFitMenuItem;

    @FXML
    private CheckMenuItem wrapTextMenuItem;

    @FXML
    private MenuItem formatMenuItem;

    @FXML
    private MenuItem showNodeAndEdgeFormatMenuItem;

    @FXML
    private MenuItem showNodeLabels;

    @FXML
    private RadioMenuItem fullGraphRadioMenuItem;

    @FXML
    private RadioMenuItem dependencyGraphRadioMenuItem;

    @FXML
    private RadioMenuItem reactantDependencyRadioMenuItem;

    @FXML
    private CheckMenuItem suppressCatalystEdgesMenuItem;

    @FXML
    private CheckMenuItem useMultiCopyFoodNodesMenuItem;

    @FXML
    private CheckMenuItem moveLabelsMenuItem;

    @FXML
    private CheckMenuItem useColorsMenuItem;

    @FXML
    private MenuItem fullScreenMenuItem;

    @FXML
    private Menu windowMenu;

    @FXML
    private MenuItem aboutMenuItem;

    @FXML
    private MenuItem checkForUpdatesMenuItem;

    @FXML
    private ToolBar mainToolBar;

    @FXML
    private Button runButton;

    @FXML
    private Button stopAnimationButton;

    @FXML
    private FlowPane statusFlowPane;

    @FXML
    private Label memoryUsageLabel;

    @FXML
    private SplitPane mainSplitPane;

    @FXML
    private VBox foodInputVBox;
    @FXML
    private TextArea inputFoodTextArea;

    @FXML
    private VBox reactionsInputVBox;

    @FXML
    private TextArea inputTextArea;

    @FXML
    private StackPane outputPane;

    @FXML
    private TabPane outputTabPane;

    @FXML
    private Tab workingReactionsTab;

    @FXML
    private TextArea workingReactionsTextArea;

    @FXML
    private VBox workingReactionsVBox;

    @FXML
    private Tab visualizationTab;

    @FXML
    private Label graphTypeLabel;

    @FXML
    private BorderPane visualizationBorderPane;

    @FXML
    private VBox visualizationVBox;

    @FXML
    private ScrollPane visualizationScrollPane;

    @FXML
    private ContextMenu visualizationContextMenu;

    @FXML
    private MenuItem selectNoneContextMenuItem;

    @FXML
    private MenuItem selectConnectedComponentContextMenuItem;

    @FXML
    private Tab logTab;

    @FXML
    private TextArea logTextArea;

    @FXML
    private MenuItem clearLogMenuItem;

    @FXML
    private VBox logVBox;

    @FXML
    private Label inputFoodSizeLabel;

    @FXML
    private Label inputReactionsSizeLabel;

    @FXML
    private CheckMenuItem useDarkThemeCheckMenuItem;

    private ZoomableScrollPane zoomableScrollPane;

    @FXML
    void initialize() {
        increaseFontSizeMenuItem.setAccelerator(new KeyCharacterCombination("+", KeyCombination.SHORTCUT_DOWN, KeyCombination.SHIFT_ANY));
        decreaseFontSizeMenuItem.setAccelerator(new KeyCharacterCombination("-", KeyCombination.SHORTCUT_DOWN, KeyCombination.SHIFT_ANY));

        // if we are running on MacOS, put the specific menu items in the right places
        if (ProgramProperties.isMacOS()) {
            getMenuBar().setUseSystemMenuBar(true);
            fileMenu.getItems().remove(getQuitMenuItem());
            // windowMenu.getItems().remove(getAboutMenuItem());
            //editMenu.getItems().remove(getPreferencesMenuItem());
        }

        visualizationTabContextMenu = visualizationTab.getContextMenu();
        visualizationTab.setContextMenu(null);

        // replace tabbed pane by splittable one

        final ArrayList<Tab> tabs = new ArrayList<>(outputTabPane.getTabs());
        outputTabPane.getTabs().clear();

        outputSplittableTabPane = new SplittableTabPane();
        outputSplittableTabPane.getTabs().addAll(tabs);
        outputPane.getChildren().setAll(outputSplittableTabPane);
        if (outputSplittableTabPane.getTabs().size() > 0)
            outputSplittableTabPane.getSelectionModel().select(0);

        final ArrayList<MenuItem> originalWindowMenuItems = new ArrayList<>(windowMenu.getItems());

        final InvalidationListener invalidationListener = observable -> {
            windowMenu.getItems().setAll(originalWindowMenuItems);
            int count = 0;
            for (IMainWindow mainWindow : MainWindowManager.getInstance().getMainWindows()) {
                if (mainWindow.getStage() != null) {
                    final String title = mainWindow.getStage().getTitle();
                    if (title != null) {
                        final MenuItem menuItem = new MenuItem(title.replaceAll("- " + ProgramProperties.getProgramName(), ""));
                        menuItem.setOnAction((e) -> mainWindow.getStage().toFront());
                        menuItem.setAccelerator(new KeyCharacterCombination("" + (++count), KeyCombination.SHORTCUT_DOWN));
                        windowMenu.getItems().add(menuItem);
                    }
                }
                if (MainWindowManager.getInstance().getAuxiliaryWindows(mainWindow) != null) {
                    for (Stage auxStage : MainWindowManager.getInstance().getAuxiliaryWindows(mainWindow)) {
                        final String title = auxStage.getTitle();
                        if (title != null) {
                            final MenuItem menuItem = new MenuItem(title.replaceAll("- " + ProgramProperties.getProgramName(), ""));
                            menuItem.setOnAction((e) -> auxStage.toFront());
                            windowMenu.getItems().add(menuItem);
                        }
                    }
                }
            }
        };
        MainWindowManager.getInstance().changedProperty().addListener(invalidationListener);
        invalidationListener.invalidated(null);

        zoomableScrollPane = new ZoomableScrollPane(null);
        visualizationBorderPane.setCenter(zoomableScrollPane);
    }

    private SplittableTabPane outputSplittableTabPane;

    private ContextMenu visualizationTabContextMenu;

    public MenuBar getMenuBar() {
        return menuBar;
    }

    public Menu getFileMenu() {
        return fileMenu;
    }

    public MenuItem getNewMenuItem() {
        return newMenuItem;
    }

    public MenuItem getOpenMenuItem() {
        return openMenuItem;
    }

    public MenuItem getImportMenuItem() {
        return importMenuItem;
    }

    public Menu getExportMenu() {
        return exportMenu;
    }

    public MenuItem getExportSelectedNodesMenuItem() {
        return exportSelectedNodesMenuItem;
    }

    public MenuItem getExportListOfReactionsMenuItem() {
        return exportListOfReactionsMenuItem;
    }

    public Menu getRecentFilesMenu() {
        return recentFilesMenu;
    }

    public MenuItem getSaveMenItem() {
        return saveMenItem;
    }

    public MenuItem getPageSetupMenuItem() {
        return pageSetupMenuItem;
    }

    public MenuItem getPrintMenuItem() {
        return printMenuItem;
    }

    public MenuItem getCloseMenuItem() {
        return closeMenuItem;
    }

    public MenuItem getQuitMenuItem() {
        return quitMenuItem;
    }

    public Menu getEditMenu() {
        return editMenu;
    }

    public MenuItem getUndoMenuItem() {
        return undoMenuItem;
    }

    public MenuItem getRedoMenuItem() {
        return redoMenuItem;
    }

    public MenuItem getCutMenuItem() {
        return cutMenuItem;
    }

    public MenuItem getCopyMenuItem() {
        return copyMenuItem;
    }

    public MenuItem getPasteMenuItem() {
        return pasteMenuItem;
    }

    public MenuItem getClearMenuItem() {
        return clearMenuItem;
    }

    public MenuItem getFindMenuItem() {
        return findMenuItem;
    }

    public MenuItem getFindAgainMenuItem() {
        return findAgainMenuItem;
    }

    public MenuItem getSelectAllMenuItem() {
        return selectAllMenuItem;
    }

    public MenuItem getSelectNoneMenuItem() {
        return selectNoneMenuItem;
    }

    public MenuItem getSelectInvertedMenuItem() {
        return selectInvertedMenuItem;
    }

    public MenuItem getSelectNodesMenuItem() {
        return selectNodesMenuItem;
    }

    public MenuItem getSelectEdgesMenuItem() {
        return selectEdgesMenuItem;
    }

    public Menu getSelectReactionSystemMenu() {
        return selectReactionSystemMenu;
    }

    public MenuItem getSelectFoodMenuItem() {
        return selectFoodMenuItem;
    }

    public MenuItem getSelectMoleculesMenuItem() {
        return selectMoleculesMenuItem;
    }

    public MenuItem getSelectReactionsMenuItem() {
        return selectReactionsMenuItem;
    }

    public MenuItem getSelectConnectedComponentMenuItem() {
        return selectConnectedComponentMenuItem;
    }

    public MenuItem getSelectFromPreviousWindowMenuItem() {
        return selectFromPreviousWindowMenuItem;
    }

    public Menu getAlgorithmMenu() {
        return algorithmMenu;
    }

    public MenuItem getComputeVisualizationMenuItem() {
        return computeVisualizationMenuItem;
    }

    public MenuItem getRunCAFMenuItem() {
        return runCAFMenuItem;
    }

    public MenuItem getRunRAFMenuItem() {
        return runRAFMenuItem;
    }

    public MenuItem getRunPseudoRAFMenuItem() {
        return runPseudoRAFMenuItem;
    }

    public MenuItem getRunMenuItem() {
        return runMenuItem;
    }

    public MenuItem getRunMuCAFMenuItem() {
        return runMuCAFMenuItem;
    }

    public MenuItem getRunURAFMenuItem() {
        return runURAFMenuItem;
    }

    public MenuItem getRunMinIrrRAFMenuItem() {
        return runMinIrrRAFMenuItem;
    }

    public MenuItem getRunTrivialCAFsAlgorithmMenuItem() {
        return runTrivialCAFsAlgorithmMenuItem;
    }

    public MenuItem getRunTrivialRAFsAlgorithmMenuItem() {
        return runTrivialRAFsAlgorithmMenuItem;
    }

    public MenuItem getRunQuotientRAFMenuItem() {
        return runQuotientRAFMenuItem;
    }

    public MenuItem getRunCoreRAFMenuItem() {
        return runCoreRAFMenuItem;
    }

    public MenuItem getRemoveTrivialRAFsAlgorithmMenuItem() {
        return removeTrivialRAFsAlgorithmMenuItem;
    }

    public MenuItem getRunMuCAFMultipleTimesMenuItem() {
        return runMuCAFMultipleTimesMenuItem;
    }

    public MenuItem getSpontaneousInRafMenuItem() {
        return spontaneousInRafMenuItem;
    }

    public MenuItem getGreedyGrowMenuItem() {
        return greedyGrowMenuItem;
    }

    public CheckMenuItem getComputeImportanceCheckMenuItem() {
        return computeImportanceCheckMenuItem;
    }

    public MenuItem getGraphEmbedderIterationsMenuItem() {
        return graphEmbedderIterationsMenuItem;
    }

    public CheckMenuItem getAnimateCAFCheckMenuItem() {
        return animateCAFCheckMenuItem;
    }

    public CheckMenuItem getAnimateRAFCheckMenuItem() {
        return animateRAFCheckMenuItem;
    }

    public CheckMenuItem getAnimateMaxRAFCheckMenuItem() {
        return animateMaxRAFCheckMenuItem;
    }

    public CheckMenuItem getAnimateInhibitionsMenuItem() {
        return animateInhibitionsMenuItem;
    }

    public MenuItem getStopAnimationMenuItem() {
        return stopAnimationMenuItem;
    }

    public MenuItem getIncreaseFontSizeMenuItem() {
        return increaseFontSizeMenuItem;
    }

    public MenuItem getDecreaseFontSizeMenuItem() {
        return decreaseFontSizeMenuItem;
    }

    public MenuItem getZoomInMenuItem() {
        return zoomInMenuItem;
    }

    public MenuItem getZoomOutMenuItem() {
        return zoomOutMenuItem;
    }

    public MenuItem getZoomToFitMenuItem() {
        return zoomToFitMenuItem;
    }

    public CheckMenuItem getWrapTextMenuItem() {
        return wrapTextMenuItem;
    }

    public MenuItem getFormatMenuItem() {
        return formatMenuItem;
    }

    public MenuItem getShowNodeAndEdgeFormatMenuItem() {
        return showNodeAndEdgeFormatMenuItem;
    }

    public MenuItem getFullScreenMenuItem() {
        return fullScreenMenuItem;
    }

    public MenuItem getShowNodeLabels() {
        return showNodeLabels;
    }

    public RadioMenuItem getFullGraphRadioMenuItem() {
        return fullGraphRadioMenuItem;
    }

    public RadioMenuItem getDependencyGraphRadioMenuItem() {
        return dependencyGraphRadioMenuItem;
    }

    public RadioMenuItem getReactantDependencyGraphRadioMenuItem() {
        return reactantDependencyRadioMenuItem;
    }

    public CheckMenuItem getSuppressCatalystEdgesMenuItem() {
        return suppressCatalystEdgesMenuItem;
    }

    public CheckMenuItem getUseMultiCopyFoodNodesMenuItem() {
        return useMultiCopyFoodNodesMenuItem;
    }

    public Menu getWindowMenu() {
        return windowMenu;
    }

    public MenuItem getAboutMenuItem() {
        return aboutMenuItem;
    }

    public MenuItem getCheckForUpdatesMenuItem() {
        return checkForUpdatesMenuItem;
    }

    public ToolBar getMainToolBar() {
        return mainToolBar;
    }

    public Button getRunButton() {
        return runButton;
    }

    public Button getStopAnimationButton() {
        return stopAnimationButton;
    }

    public FlowPane getStatusFlowPane() {
        return statusFlowPane;
    }

    public Label getMemoryUsageLabel() {
        return memoryUsageLabel;
    }

    public SplitPane getMainSplitPane() {
        return mainSplitPane;
    }

    public VBox getFoodInputVBox() {
        return foodInputVBox;
    }

    public TextArea getInputFoodTextArea() {
        return inputFoodTextArea;
    }

    public VBox getReactionsInputVBox() {
        return reactionsInputVBox;
    }

    public TextArea getInputTextArea() {
        return inputTextArea;
    }

    public Tab getWorkingReactionsTab() {
        return workingReactionsTab;
    }

    public TextArea getWorkingReactionsTextArea() {
        return workingReactionsTextArea;
    }

    public VBox getWorkingReactionsVBox() {
        return workingReactionsVBox;
    }

    public Tab getVisualizationTab() {
        return visualizationTab;
    }

    public Label getGraphTypeLabel() {
        return graphTypeLabel;
    }

    public BorderPane getVisualizationBorderPane() {
        return visualizationBorderPane;
    }

    public VBox getVisualizationVBox() {
        return visualizationVBox;
    }

    public ContextMenu getVisualizationContextMenu() {
        return visualizationContextMenu;
    }

    public MenuItem getSelectNoneContextMenuItem() {
        return selectNoneContextMenuItem;
    }

    public MenuItem getSelectConnectedComponentContextMenuItem() {
        return selectConnectedComponentContextMenuItem;
    }

    public Tab getLogTab() {
        return logTab;
    }

    public TextArea getLogTextArea() {
        return logTextArea;
    }

    public MenuItem getClearLogMenuItem() {
        return clearLogMenuItem;
    }

    public VBox getLogVBox() {
        return logVBox;
    }


    public SplittableTabPane getOutputTabPane() {
        return outputSplittableTabPane;
    }

    public ContextMenu getVisualizationTabContextMenu() {
        return visualizationTabContextMenu;
    }

    public Label getInputFoodSizeLabel() {
        return inputFoodSizeLabel;
    }

    public Label getInputReactionsSizeLabel() {
        return inputReactionsSizeLabel;
    }

    public ZoomableScrollPane getVisualizationScrollPane() {
        return zoomableScrollPane;
    }

    public CheckMenuItem getMoveLabelsMenuItem() {
        return moveLabelsMenuItem;
    }

    public CheckMenuItem getUseColorsMenuItem() {
        return useColorsMenuItem;
    }

    public CheckMenuItem getUseDarkThemeCheckMenuItem() {
        return useDarkThemeCheckMenuItem;
    }
}