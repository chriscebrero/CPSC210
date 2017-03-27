package ca.ubc.cs.cpsc210.test;

import ca.ubc.cs.cpsc210.photo.Tag;
import ca.ubc.cs.cpsc210.photo.TagManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests basic operations of TagManager
 */
public class TagManagerTest {
	
	private TagManager aTagManager;

	@Before
	public void setUp() {
		aTagManager = new TagManager();
	}

	@Test
	public void testCreateUniqueTags()  {
		aTagManager.createTag("birthday");
		aTagManager.createTag("AuntBetty");
		assertEquals(2, aTagManager.getTags().size());
		assertNotNull(aTagManager.findTag("birthday"));
		assertNotNull(aTagManager.findTag("AuntBetty"));
	}

    @Test
    public void testCreateDuplicateTag() {
        Tag someTag = aTagManager.createTag("Some Tag");
        assertTrue(someTag == aTagManager.createTag("Some Tag"));
    }
	
	@Test 
	public void testRemoveTag()  {
		aTagManager.createTag("birthday");
		aTagManager.createTag("AuntBetty");
		assertEquals(2, aTagManager.getTags().size());
		assertTrue(aTagManager.removeTag("birthday"));
		assertEquals(1, aTagManager.getTags().size());
		assertNotNull(aTagManager.findTag("AuntBetty"));
	}
	
	@Test
	public void testRemoveTagTwice()  {
		aTagManager.createTag("birthday");
		aTagManager.removeTag("birthday");
		assertFalse(aTagManager.removeTag("birthday"));
	}

    @Test
    public void testRemoveTagDoesntExist() {
        assertFalse(aTagManager.removeTag("Does Not Exist"));
    }

	@Test
	public void testRenameTag()  {
		aTagManager.createTag("birthday");
		Tag birthdayTag = aTagManager.findTag("birthday");
		assertTrue(aTagManager.renameTag("birthday", "newBirthday"));
		assertNull(aTagManager.findTag("birthday"));
		assertNotNull(aTagManager.findTag("newBirthday"));
		assertEquals(birthdayTag, aTagManager.findTag("newBirthday"));
		assertTrue(aTagManager.renameTag("newBirthday", "birthday"));
	}

    @Test
    public void testRenameTagToDuplicateName() {
        aTagManager.createTag("Some Tag");
        aTagManager.createTag("Other Tag");
        assertFalse(aTagManager.renameTag("Some Tag", "Other Tag"));
    }

    @Test
    public void testRenameToSame() {
        aTagManager.createTag("A Tag");
        assertFalse(aTagManager.renameTag("A Tag", "A Tag"));
    }

    @Test
    public void testRenameTagnull() {
        aTagManager.createTag(null);
        assertFalse(aTagManager.renameTag("", "Robin is bullshit"));
    }
}
