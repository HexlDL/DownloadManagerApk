package com.hexl.downloadmanager;

import android.app.DownloadManager;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * 使用downloadManager下载apk文件
 */
public class MainActivity extends AppCompatActivity {
    long downloadId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        DownloadUtil downloadUtil = new DownloadUtil(this);
        if (downloadId != 0) {
            downloadUtil.clearCurrentTask(downloadId);
        }
        downloadUtil.download("http://192.168.2.76:8080/baseAdapter.apk", "test下载", "这是一个基类适配器的下载链接");

       /* DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        if (manager == null) {
            return;
        }
        long enqueue = manager.enqueue(new DownloadManager
                .Request(Uri.parse("http://192.168.2.76:8080/baseAdapter.apk"))
                .setTitle("正在下载apk...")
                .setMimeType("application/vnd.android.package-archive")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)
        );
        Log.d("MainActivity", "enqueue:" + enqueue);
        DownloadManager.Query query = new DownloadManager.Query();
        query.setFilterById(enqueue);
        Cursor cursor = manager.query(query);
        while (cursor.moveToNext()) {
            String bytesDownload = cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));
            String descrition = cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_DESCRIPTION));
            String id = cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_ID));
            String localUri = cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI));
            String mimeType = cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_MEDIA_TYPE));
            String title = cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_TITLE));
            String status = cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS));
            String totalSize = cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));

            Log.i("MainActivity", "bytesDownload:" + bytesDownload);
            Log.i("MainActivity", "descrition:" + descrition);
            Log.i("MainActivity", "id:" + id);
            Log.i("MainActivity", "localUri:" + localUri);
            Log.i("MainActivity", "mimeType:" + mimeType);
            Log.i("MainActivity", "title:" + title);
            Log.i("MainActivity", "status:" + status);
            Log.i("MainActivity", "totalSize:" + totalSize);
        }*/
    }
}
