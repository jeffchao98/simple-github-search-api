package com.scchao.githubsearcher;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.scchao.githubsearcher.interfaces.RequestFetchListener;
import com.scchao.githubsearcher.models.RepoItem;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    Context context;
    GitRepoSearcher searcher;

    @Before
    public void beforeTest() {
        context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        searcher = new GitRepoSearcher(context);
    }

    @Test
    public void normalFetchParserCase() {
        searcher.searchWith("android", "rakutentech",
                new RequestFetchListener() {
                    @Override
                    public void onFetch(boolean success, List<RepoItem> items) {
                        assertEquals(true, success);
                        assertTrue(items.size() > 0);
                    }
                });
    }

    @Test
    public void fetchParserCaseWithRandomInput() {
        searcher.searchWith("adakjdjln", "klklejlkr",
                new RequestFetchListener() {
                    @Override
                    public void onFetch(boolean success, List<RepoItem> items) {
                        assertEquals(false, success);
                    }
                });
    }
}