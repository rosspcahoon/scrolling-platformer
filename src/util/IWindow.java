package util;

import viewUtil.Renderable;
import viewUtil.WorkspaceView;

public interface IWindow {

    void addWorkspace (WorkspaceView associatedTab, Renderable r);

}
