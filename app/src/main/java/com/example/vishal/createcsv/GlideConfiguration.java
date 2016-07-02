package com.example.vishal.createcsv;

import android.content.Context;
import android.os.Environment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.module.GlideModule;

import java.io.File;

/**
 * Created by vishal on 01/07/2016.
 */
public class GlideConfiguration implements GlideModule {

    @Override
    public void applyOptions(final Context context, GlideBuilder builder) {


        builder.setDiskCache(
                new DiskCache.Factory() {
                    @Override
                    public DiskCache build() {
                        return DiskLruCacheWrapper.get(
                                Glide.getPhotoCacheDir(context),
                                ConfigConstants.MAX_DISK_CACHE_SIZE);
                    }
                });
        builder.setMemoryCache(new LruResourceCache(ConfigConstants.MAX_MEMORY_CACHE_SIZE));

        // Apply options to the builder here.

//        File sdDir = Environment.getExternalStorageDirectory();
//        String path = sdDir.getAbsolutePath() + "/demo/";
//        File sgDir = new File(path);
//        if (!sgDir.exists()) {
//            sgDir.mkdirs();
//        }
//
//        MemorySizeCalculator calculator = new MemorySizeCalculator(context);
//        int defaultMemoryCacheSize = calculator.getMemoryCacheSize();
//        int defaultBitmapPoolSize = calculator.getBitmapPoolSize();
//
//        int customMemoryCacheSize = (int) (1.2 * defaultMemoryCacheSize);
//        int customBitmapPoolSize = (int) (1.2 * defaultBitmapPoolSize);
//
//        builder.setMemoryCache( new LruResourceCache( customMemoryCacheSize ));
//        builder.setBitmapPool( new LruBitmapPool( customBitmapPoolSize ));
//
//        int cacheSize100MegaBytes = 104857600;
//        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
//
//        builder.setDiskCache(new InternalCacheDiskCacheFactory(context, cacheSize100MegaBytes));
//        builder.setDiskCache(
//                new ExternalCacheDiskCacheFactory(context, cacheSize100MegaBytes));
//        // or any other path
//        String downloadDirectoryPath = Environment.getDownloadCacheDirectory().getPath();
//
//        builder.setDiskCache(
//                new DiskLruCacheFactory( path, cacheSize100MegaBytes )
//        );

// In case you want to specify a cache sub folder (i.e. "glidecache"):
//builder.setDiskCache(
//    new DiskLruCacheFactory( downloadDirectoryPath, "glidecache", cacheSize100MegaBytes )
//);
    }

    @Override
    public void registerComponents(Context context, Glide glide) {
        // register ModelLoaders here.
    }
}
