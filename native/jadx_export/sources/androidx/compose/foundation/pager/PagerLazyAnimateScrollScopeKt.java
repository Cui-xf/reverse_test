package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* compiled from: PagerLazyAnimateScrollScope.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¨\u0006\u0004"}, d2 = {"PagerLazyAnimateScrollScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", "state", "Landroidx/compose/foundation/pager/PagerState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PagerLazyAnimateScrollScopeKt {
    public static final LazyLayoutAnimateScrollScope PagerLazyAnimateScrollScope(final PagerState state) {
        return new LazyLayoutAnimateScrollScope() { // from class: androidx.compose.foundation.pager.PagerLazyAnimateScrollScopeKt.PagerLazyAnimateScrollScope.1
            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
            public int getFirstVisibleItemIndex() {
                return state.getFirstVisiblePage();
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
            public int getFirstVisibleItemScrollOffset() {
                return state.getFirstVisiblePageOffset();
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
            public int getLastVisibleItemIndex() {
                return ((PageInfo) CollectionsKt.last((List) state.getLayoutInfo().getVisiblePagesInfo())).getIndex();
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
            public int getItemCount() {
                return state.getPageCount();
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
            public void snapToItem(ScrollScope $this$snapToItem, int index, int scrollOffset) {
                float offsetFraction = scrollOffset / state.getPageSizeWithSpacing$foundation_release();
                state.snapToItem$foundation_release(index, offsetFraction, true);
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
            public float calculateDistanceTo(int targetIndex) {
                Object it$iv;
                List $this$fastFirstOrNull$iv = state.getLayoutInfo().getVisiblePagesInfo();
                int index$iv$iv = 0;
                int size = $this$fastFirstOrNull$iv.size();
                while (true) {
                    if (index$iv$iv < size) {
                        Object item$iv$iv = $this$fastFirstOrNull$iv.get(index$iv$iv);
                        it$iv = item$iv$iv;
                        PageInfo it = (PageInfo) it$iv;
                        if (it.getIndex() == targetIndex) {
                            break;
                        }
                        index$iv$iv++;
                    } else {
                        it$iv = null;
                        break;
                    }
                }
                PageInfo visibleItem = (PageInfo) it$iv;
                if (visibleItem == null) {
                    return ((targetIndex - state.getCurrentPage()) * getVisibleItemsAverageSize()) - (state.getCurrentPageOffsetFraction() * state.getPageSizeWithSpacing$foundation_release());
                }
                return visibleItem.getOffset();
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
            public Object scroll(Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
                Object objScroll$default = ScrollableState.CC.scroll$default(state, null, function2, continuation, 1, null);
                return objScroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll$default : Unit.INSTANCE;
            }

            private final int getVisibleItemsAverageSize() {
                return state.getPageSize$foundation_release() + state.getPageSpacing$foundation_release();
            }
        };
    }
}
