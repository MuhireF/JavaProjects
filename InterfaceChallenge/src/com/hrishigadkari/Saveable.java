package com.hrishigadkari;

import java.util.ArrayList;
import java.util.List;

public interface Saveable {

    void read(List<String> savedValues);
    List<String> write();
}
