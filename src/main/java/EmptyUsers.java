/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */

import java.util.Collections;
import java.util.List;

public class EmptyUsers implements Users {
    @Override
    public List<User> all() {
        return Collections.emptyList();
    }
}
