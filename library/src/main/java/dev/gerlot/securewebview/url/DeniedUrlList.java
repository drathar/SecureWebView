package dev.gerlot.securewebview.url;

import android.net.Uri;

import androidx.annotation.NonNull;

import java.util.Collection;

/**
 * A denyList of URLs. This will reject a match for any URL on the list, and permit all others.
 */
public class DeniedUrlList extends UrlList implements UriMatcher {

    public DeniedUrlList() {
        super();
    }

    public DeniedUrlList(UriMatcher... matchers) {
        super(matchers);
    }

    public DeniedUrlList(Collection<UriMatcher> matchers) {
        super(matchers);
    }

    @Override
    public boolean matches(@NonNull Uri uri) {
        for (UriMatcher matcher : mUriMatchers) {
            if (matcher.matches(uri)) {
                return false;
            }
        }

        return true;
    }
}
