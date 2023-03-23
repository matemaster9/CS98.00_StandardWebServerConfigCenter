package org.mastercs.biz.cases;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author matemaster
 */
public class CartesianProductCase {

    @SafeVarargs
    public static List<String> getCartesianProduct(List<String>... lists) {
        if (ArrayUtils.isEmpty(lists)) {
            return Collections.emptyList();
        }

        List<String> tempList = null;
        for (List<String> list : lists) {
            if (Objects.isNull(tempList)) {
                tempList = list;
            } else {
                tempList = tempList.stream().flatMap(elem1 -> list.stream().map(elem2 -> elem1 + " " + elem2)).collect(Collectors.toList());
            }
        }
        return tempList;
    }
}
