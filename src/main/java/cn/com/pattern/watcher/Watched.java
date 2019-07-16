package cn.com.pattern.watcher;

public interface Watched {
	public void addWatcher(Watcher watcher);

	public void removeWatcher(Watcher watcher);

	public void notifyWatchers();

}
