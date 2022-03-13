package com.ui.nestedrecylerview;

import java.util.List;

public class ParentModal {
    String Title;

    public ParentModal(String title, List<ChildModal> childModalList) {
        Title = title;
        this.childModalList = childModalList;
    }

    List<ChildModal> childModalList;
}
