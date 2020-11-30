package com.scchao.githubsearcher;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.scchao.githubsearcher.helper.DataParser;
import com.scchao.githubsearcher.models.RepoItem;
import com.scchao.githubsearcher.models.RepoSearchResult;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Test
    public void normalParserTestCase() {
        String rawData = "{'items':[{" +
                "'name': 'test01','full_name': 'test01_full'," +
                "'description': 'description of test01'," +
                "'language': 'Python','private': true}]}";
        RepoItem verifyItem = new RepoItem();
        verifyItem.name = "test01";
        verifyItem.fullName = "test01_full";
        verifyItem.description = "description of test01";
        verifyItem.language = "Python";
        verifyItem.privateStatus = true;
        RepoSearchResult testParsedData = DataParser.parserResult(rawData);
        Assert.assertEquals(1, testParsedData.items.size());
        RepoItem fetchedFirstItem = testParsedData.items.get(0);
        Assert.assertEquals(verifyItem.name, fetchedFirstItem.name);
        Assert.assertEquals(verifyItem.fullName, fetchedFirstItem.fullName);
        Assert.assertEquals(verifyItem.description, fetchedFirstItem.description);
        Assert.assertEquals(verifyItem.language, fetchedFirstItem.language);
        Assert.assertEquals(verifyItem.privateStatus, fetchedFirstItem.privateStatus);
    }

    @Test
    public void exceptParserTestCaseWithInvalidData() {
        String rawData = "{'items':[{'name': 'test01','full_name': 'test01_full','description': 'description of test01','language': 'Java','private': true,}],}";
        RepoSearchResult testParsedData = DataParser.parserResult(rawData);
        Assert.assertEquals(0, testParsedData.items.size());
    }

    @Test
    public void exceptParserTestCaseWithEmptyItems() {
        String rawData = "{'items':[]}";
        RepoSearchResult testParsedData = DataParser.parserResult(rawData);
        Assert.assertEquals(0, testParsedData.items.size());
    }

    @Test
    public void exceptParserTestCaseWithEmptyData() {
        String rawData = "{}";
        RepoSearchResult testParsedData = DataParser.parserResult(rawData);
        Assert.assertEquals(0, testParsedData.items.size());
    }

}