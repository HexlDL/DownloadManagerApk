package com.hexl.downloadmanager;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;

import java.util.Objects;

public class DownloadUtil {
    private Context mContext;

    public DownloadUtil(Context context) {
        mContext = context;
    }

    public long download(String url, String title, String desc) {
        Uri uri = Uri.parse(url);
        DownloadManager manager = (DownloadManager) mContext.getSystemService(Context.DOWNLOAD_SERVICE);
        if (manager != null) {
            return manager.enqueue(new DownloadManager.Request(uri)
                    .setTitle(title)
                    .setDescription(desc)
                    .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                    .setDestinationInExternalFilesDir(mContext, Environment.DIRECTORY_DOWNLOADS, title)
                    .setMimeType("application/vnd.android.package-archive"));
        }
        return -1;
    }

    /**
     * 下载前先移除前一个任务，防止重复下载
     *
     * @param downloadId
     */
    public void clearCurrentTask(long downloadId) {
        DownloadManager dm = (DownloadManager) mContext.getSystemService(Context.DOWNLOAD_SERVICE);
        Objects.requireNonNull(dm).remove(downloadId);
    }
}
